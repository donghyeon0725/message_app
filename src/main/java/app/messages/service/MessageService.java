package app.messages.service;

import app.messages.model.Message;
import app.messages.repository.MessageRepository;
import app.messages.security.SecurityCheck;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
* 서비스 생성하기
*
* 1. @Component 추가
* 2. aop 에 관련한 관심사는 어노테이션으로 관리
* 3. Repository 와 Entity 클래스와 data를 이용해서 비지니스 로직을 만든다.
* */
@Component
public class MessageService {

  private MessageRepository repository;

  public MessageService(MessageRepository repository) {
    this.repository = repository;
  }

  /**
   * @Transactional(readOnly = true) 을 설정하는 이유
   *
   * 1. 명시적으로 select 작업만 일어나는 것을 메소드만 보고 확인할 수 있다.
   * 2. 하이버네이트의 경우 dirty checking 하는 작업을 생략해서 성능상의 이점을 가져옴
   * 3. 트랜잭션에서 의도치 않게 데이터를 변경하는 것을 막을 수 있음
   * */
  @Transactional(readOnly = true)
  public List<Message> getMessages() {
    return repository.getMessages();
  }

  /**
   * 특정 에러의 경우 롤백하지 않도록 설정하기
   *
   * (noRollbackFor = { UnsupportedOperationException.class })
   * 이렇게 해서 DB와의 상호작용이 실패 했던 기록 자체는 DB에 남길 수 있다.
   * */
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
