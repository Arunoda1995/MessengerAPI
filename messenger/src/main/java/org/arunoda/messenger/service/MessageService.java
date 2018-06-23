package org.arunoda.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.arunoda.messenger.database.Database;
import org.arunoda.messenger.model.Message;

public class MessageService {
	
	private Map<Long,Message> messages = Database.getMessages();
	
	public MessageService()
	{
		messages.put(1L, new Message(1,"Hello World","Arunoda"));
		messages.put(2L, new Message(2,"Hello jesry","Aruna"));
	}
	
	public List<Message> getAllMessages()
	{
		
		return new ArrayList<Message>(messages.values());
		
	}

	public Message getMassages(long id)
	{
		return messages.get(id);
	}
	
	public Message addMessage(Message message)
	{
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
		
	}
	
	public Message updateMessage(Message message)
	{
		if(message.getId() <= 0)
		{
			return null;
		}
		
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(Message message)
	{
		return messages.remove(message.getId());
	}
}
