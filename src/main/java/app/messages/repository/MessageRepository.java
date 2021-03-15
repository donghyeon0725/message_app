package app.messages.repository;

import app.messages.model.Message;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageRepository {

  private SessionFactory sessionFactory;

  public MessageRepository(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public Message saveMessage(Message message) {
    Session session = sessionFactory.getCurrentSession();
    session.save(message);
    return message;
  }

  public List<Message> getMessages() {
    Session session = sessionFactory.getCurrentSession();
    String hql = "from Message"; // 여기서 select 쿼리문을 생성할 수 있다.
    Query<Message> query = session.createQuery(hql, Message.class);
    return query.list();
  }

  public Message deleteMessage(Message message) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(message);
    return new Message("200");
  }

  public Message updateMessage(Message message) {
    Session session = sessionFactory.getCurrentSession();
    session.update(message);
    return new Message("200");
  }
}
