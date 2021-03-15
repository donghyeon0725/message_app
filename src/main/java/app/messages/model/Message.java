package app.messages.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 엔티티 파일 생성하기
 *
 * 1. @Entity 으로 엔티티 클래스 선언하기
 * 2. @Table 으로 매핑할 테이블 명시하기
 * 3. 필드와 hashcode, equals 구현하기
 * */
@Entity
@Table(name = "messages")
public class Message {
  /**
   * 키 생성하기
   *
   * 1. @Id 으로 명시하기
   * 2. @GeneratedValue(strategy = GenerationType.IDENTITY) 으로 식별자임을 알리기
   * 3. @Column(name = "id", nullable = false) 으로 컬럼 속성 정의하기
   * */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "text", nullable = true, length = 128)
  private String text;

  @Column(name = "created_date", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  public Message() {
  }

  public Message(String text) {
    this.text = text;
    this.createdDate = new Date();
  }

  public Message(Integer id) {
    this.id = id;
    this.createdDate = new Date();
  }

  /**
   * setter 대신 getter와 생성자만 제공
   * */
  public Message(Integer id, String text) {
    this.id = id;
    this.text = text;
    this.createdDate = new Date();
  }

  public Integer getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setId(Integer id) {this.id = id;}
  public void setText(String text) {this.text = text;}

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  /**
   * 자동 생성한 equals와 hashCode 자동 생성으로 생성하기
   * */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Message message = (Message) o;
    return Objects.equals(id, message.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
