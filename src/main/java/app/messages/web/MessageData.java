package app.messages.web;

public class MessageData {
  private Integer id;
  private String text;
  public String getText() {
    return this.text;
  }
  public void setText(String text) {
    this.text = text;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
