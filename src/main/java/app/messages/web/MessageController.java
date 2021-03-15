package app.messages.web;

import app.messages.model.Message;
import app.messages.service.MessageService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageController {

  private MessageService messageService;

  public MessageController(MessageService messageService) {
    this.messageService = messageService;
  }

  @GetMapping("/messages")
  public String index() {
    return "index";
  }

  @GetMapping("/messages/welcome")
  public String welcome(Model model) {
    model.addAttribute("message", "Hello, Welcome to Spring Boot!");
    return "welcomes";
  }

  @GetMapping("/api/messages")
  @ResponseBody
  public ResponseEntity<List<Message>> getMessages() {
    List<Message> messages = messageService.getMessages();
    return ResponseEntity.ok(messages);
  }

  @PostMapping("/api/messages")
  @ResponseBody
  public ResponseEntity<Message> saveMessage(@RequestBody MessageData data) {
    Message saved = messageService.save(data.getText());
    if (saved == null) {
      return ResponseEntity.status(500).build();
    }
    return ResponseEntity.ok(saved);
  }

  @DeleteMapping("/api/messages")
  @ResponseBody
  public ResponseEntity<Message> deleteMessage(@RequestBody MessageData data) {
    Message saved = messageService.delete(data.getId());
    if (saved == null) {
      return ResponseEntity.status(500).build();
    }
    return ResponseEntity.ok(saved);
  }

  @PutMapping("/api/messages")
  @ResponseBody
  public ResponseEntity<Message> putMapping(@RequestBody MessageData data) {
    Message saved = messageService.update(data.getId(), data.getText());
    if (saved == null) {
      return ResponseEntity.status(500).build();
    }
    return ResponseEntity.ok(saved);
  }
}
