// Component interface
interface Text {
    String getText();
}

// Concrete component
class PlainText implements Text {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}

// Decorator
abstract class TextDecorator implements Text {
    protected Text decoratedText;

    public TextDecorator(Text decoratedText) {
        this.decoratedText = decoratedText;
    }

    @Override
    public String getText() {
        return decoratedText.getText();
    }
}

// Concrete decorators
class BoldText extends TextDecorator {
    public BoldText(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getText() {
        return "<b>" + decoratedText.getText() + "</b>";
    }
}

class ItalicText extends TextDecorator {
    public ItalicText(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getText() {
        return "<i>" + decoratedText.getText() + "</i>";
    }
}

class UnderlineText extends TextDecorator {
    public UnderlineText(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getText() {
        return "<u>" + decoratedText.getText() + "</u>";
    }
}

// Usage
public class TextEditorApp {
    public static void main(String[] args) {
        Text text = new PlainText("Hello, World!");
        System.out.println(text.getText());

        Text boldText = new BoldText(text);
        System.out.println(boldText.getText());

        Text italicText = new ItalicText(text);
        System.out.println(italicText.getText());

        Text underlineText = new UnderlineText(text);
        System.out.println(underlineText.getText());
    }
}
