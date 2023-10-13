package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * Represents properties of the body of an item, such as a message, event or
 * group post.
 */
public interface ItemBody extends MsGraphData {
    /**
     * The content of the item.
     * 
     * @return the value
     */
    String content();

    /**
     * The type of the content. Possible values are text and html.
     * 
     * @return the value
     */
    String contentType();

    public interface Builder {
        public ItemBody build();
        Builder content(String content);
        Builder contentType(String contentType);
    }
}
