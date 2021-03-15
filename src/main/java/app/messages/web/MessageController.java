package app.messages.web;

import app.messages.model.Message;
import app.messages.service.MessageService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 컨트롤러 생성하기
 *
 * 1. @Controller
 * 2. 받을 서비스로 생성자 생성하기
 * 3. api (json 등등) 데이터로 통신할 경우 @ResponseBody 태그 필요. url은 별도 api 로 구분. 값을 반환할 때는 ResponseEntity 으로 한다.
 * 4. api 형식으로 온 통신은 @RequestBody 으로 받는다.
 * 4. GetMapping(조회), PostMapping(삽입), PutMapping(수정), DeleteMapping(삭제)
 * */
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

  @PutMapping("/api/messages")
  @ResponseBody
  public ResponseEntity<Message> putMapping(@RequestBody MessageData data) {
    Message saved = messageService.update(data.getId(), data.getText());
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
}
