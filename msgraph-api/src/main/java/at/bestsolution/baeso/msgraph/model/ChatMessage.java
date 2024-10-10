package at.bestsolution.baeso.msgraph.model;

import java.util.function.Function;

import at.bestsolution.baeso.msgraph.base.ID;

public interface ChatMessage {
    // attachments: chatMessageAttachment
    public ItemBody body();
    // chatId: string
    // channelIdentity
    // createdDateTime
    // deletedDateTime
    // etag
    // eventDetail
    // from
    public ID<ChatMessage> id();
    // importance
    // lastModifiedDateTime
    // lastEditedDateTime
    // locale
    // mentions
    // messageHistory
    // messageType
    // policyViolation
    // reactions
    // replyToId
    public String subject();
    // summary
    // webUrl

    public interface Builder {
        ChatMessage build();

        public Builder body(ItemBody body);
        public Builder withBody(Function<ItemBody.Builder, ItemBody> builder);
        public Builder subject(String subject);
    }
}
