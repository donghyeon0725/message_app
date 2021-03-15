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

@Entity
@Table(name = "messages")
public class Message {

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
