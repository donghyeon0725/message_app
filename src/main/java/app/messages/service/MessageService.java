package app.messages.service;

import app.messages.model.Message;
import app.messages.repository.MessageRepository;
import app.messages.security.SecurityCheck;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MessageService {

  private MessageRepository repository;

  public MessageService(MessageRepository repository) {
    this.repository = repository;
  }

  @Transactional(readOnly = true)
  public List<Message> getMessages() {
    return repository.getMessages();
  }

  @SecurityCheck
  @Transactional(noRollbackFor = { UnsupportedOperationException.class })
  public Message save(String text) {
    return repository.saveMessage(new Message(text));
  }

  @SecurityCheck
  @Transactional
  public Message delete(int id) {
    return repository.deleteMessage(new Message(id));
  }

  @SecurityCheck
  @Transactional
  public Message update(int id, String text) {
    return repository.updateMessage(new Message(id, text));
  }
}
