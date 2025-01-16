package dev.seanlyon.infergui;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/generate")
    public String generate(
            @RequestParam(defaultValue = "Tell me a joke") String message
    ) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

    @GetMapping("/generate-stream")
    public Flux<String> generateStream(
            @RequestParam(defaultValue = "Tell me a joke") String message
    ) {
         return chatClient.prompt()
                .user(message)
                .stream()
                .content();
    }
}
