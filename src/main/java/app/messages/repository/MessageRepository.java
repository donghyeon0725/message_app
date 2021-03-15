package app.messages.repository;

import app.messages.model.Message;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 1. 컴포넌트로 등록 @Component
 * 2. SessionFactory 를 제공받기
 * 3. 세션을 열어 CRUD (주의 할 점)
 *        : sessionFactory.openSession        => 세로운 세션 열기
 *        : sessionFactory.getCurrentSession  => 기존 트랜젝션이 열어 놓은 세션에 접근
 * */
@Component
public class MessageRepository {
  private SessionFactory sessionFactory;

  public MessageRepository(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * select
   *
   * 1. hql (Hibernate Query Language) 으로 "from + DB 이름" 을 넘겨준다.
   * 2. Entity 클래스인 Message 을 넘겨주고 쿼리 생성과 동시에 Entity 객체를 가져옴
   * */
  public List<Message> getMessages() {
    Session session = sessionFactory.getCurrentSession();
    String hql = "from Message"; // 여기서 select 쿼리문을 생성할 수 있다.
    Query<Message> query = session.createQuery(hql, Message.class);
    return query.list();
  }

  /**
   * insert
   * */
  public Message saveMessage(Message message) {
    Session session = sessionFactory.getCurrentSession();
    session.save(message);
    return message;
  }

  /**
   * update
   * */
  public Message updateMessage(Message message) {
    Session session = sessionFactory.getCurrentSession();
    session.update(message);
    return new Message("200");
  }

  /**
   * delete
   * */
  public Message deleteMessage(Message message) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(message);
    return new Message("200");
  }
}
