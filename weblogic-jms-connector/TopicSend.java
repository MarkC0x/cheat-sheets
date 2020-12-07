import java.io.*;
import java.util.*;
import javax.transaction.*;
import javax.naming.*;
import javax.jms.*;
import javax.rmi.PortableRemoteObject;
public class TopicSend
{
public final static String JNDI_FACTORY="weblogic.jndi.WLInitialContextFactory";
public final static String JMS_FACTORY="MACCF";
public final static String TOPIC="MAC-DT";
 
protected TopicConnectionFactory tconFactory;
protected TopicConnection tcon;
protected TopicSession tsession;
protected TopicPublisher tpublisher;
protected Topic topic;
protected TextMessage msg;
 
public void init(Context ctx, String topicName) throws NamingException, JMSException
{
tconFactory = (TopicConnectionFactory) PortableRemoteObject.narrow(ctx.lookup(JMS_FACTORY),TopicConnectionFactory.class);
tcon = tconFactory.createTopicConnection();
tsession = tcon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
topic = (Topic) PortableRemoteObject.narrow(ctx.lookup(topicName), Topic.class);
tpublisher = tsession.createPublisher(topic);
msg = tsession.createTextMessage();
tcon.start();
}
 
public void send(String message) throws JMSException {
msg.setText(message);
tpublisher.publish(msg);
}
 
public void close() throws JMSException {
tpublisher.close();
tsession.close();
tcon.close();
}
 
public static void main(String[] args) throws Exception {
if (args.length != 1) {
System.out.println("Usage: java examples.jms.topic.TopicSend WebLogicURL");
return;
}
InitialContext ic = getInitialContext(args[0]);
TopicSend ts = new TopicSend();
ts.init(ic, TOPIC);
readAndSend(ts);
ts.close();
}
 
protected static void readAndSend(TopicSend ts)throws IOException, JMSException
{
BufferedReader msgStream = new BufferedReader (new InputStreamReader(System.in));
String line=null;
System.out.print("TopicSender Started ... Enter message (\"quit\" to quit): \n");
do {
System.out.print("Topic Sender Says > ");
line = msgStream.readLine();
if (line != null && line.trim().length() != 0) {
ts.send(line);
}
} while (line != null && ! line.equalsIgnoreCase("quit"));
}
 
protected static InitialContext getInitialContext(String url)
throws NamingException
{
Hashtable<String,String> env = new Hashtable<String,String>();
env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
env.put(Context.PROVIDER_URL, url);
env.put("weblogic.jndi.createIntermediateContexts", "true");
return new InitialContext(env);
}
}

