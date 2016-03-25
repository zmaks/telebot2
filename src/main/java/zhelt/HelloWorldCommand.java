package zhelt;

import io.github.nixtabyte.telegram.jtelebot.client.RequestHandler;
import io.github.nixtabyte.telegram.jtelebot.exception.JsonParsingException;
import io.github.nixtabyte.telegram.jtelebot.exception.TelegramServerException;
import io.github.nixtabyte.telegram.jtelebot.request.TelegramRequest;
import io.github.nixtabyte.telegram.jtelebot.request.factory.TelegramRequestFactory;
import io.github.nixtabyte.telegram.jtelebot.response.json.Message;
import io.github.nixtabyte.telegram.jtelebot.server.impl.AbstractCommand;

import java.io.File;

public class HelloWorldCommand extends AbstractCommand {

    public HelloWorldCommand(Message message, RequestHandler requestHandler) {
        super(message, requestHandler);
    }

    @Override
    public void execute() {
        try {
            TelegramRequest telegramRequest;
            telegramRequest = TelegramRequestFactory.createSendMessageRequest(message.getChat().getId(), "Не понял... Ты кто?", true, null, null);
            if(message.getText().contains("апряга, пожалуйста")) {
                String path = "C://Users//Максим//Dropbox//CSF//Квантовая теория";
                //path.replace("!","/");
                telegramRequest = TelegramRequestFactory.createSendDocumentRequest(message.getChat().getId(),new File(path, "att1.ppt") , null, null);
            }
            if(message.getText().startsWith("Я")|| message.getText().startsWith("я")) {
                String name = message.getText().substring(2);
                telegramRequest = TelegramRequestFactory.createSendMessageRequest(message.getChat().getId(), "О! Здарова, "+name+"! А я бот, пижжу инфу с флешек преподов))) Чего хотел?", true, message.getId(), null);
            }


            requestHandler.sendRequest(telegramRequest);
        } catch ( TelegramServerException e) {
            e.printStackTrace();
        } catch (JsonParsingException e) {
            e.printStackTrace();
        }
    }
}