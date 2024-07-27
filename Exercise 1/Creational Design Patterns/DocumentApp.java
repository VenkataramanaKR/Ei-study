// Product interface
interface Document {
    void open(String filename);
}

// Concrete product
class WordDocument implements Document {
    @Override
    public void open(String filename) {
        System.out.println("Opening Word document: " + filename);
    }
}

// Concrete product
class ExcelDocument implements Document {
    @Override
    public void open(String filename) {
        System.out.println("Opening Excel document: " + filename);
    }
}

// Concrete product
class PDFDocument implements Document {
    @Override
    public void open(String filename) {
        System.out.println("Opening PDF document: " + filename);
    }
}

// Factory
class DocumentFactory {
    public static Document createDocument(String filename) {
        String fileType = getFileExtension(filename).toUpperCase();

        switch (fileType) {
            case "DOC":
            case "DOCX":
                return new WordDocument();
            case "XLS":
            case "XLSX":
                return new ExcelDocument();
            case "PDF":
                return new PDFDocument();
            default:
                throw new IllegalArgumentException("Unknown document type for file: " + filename);
        }
    }

    private static String getFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < filename.length() - 1) {
            return filename.substring(dotIndex + 1);
        } else {
            throw new IllegalArgumentException("File without extension: " + filename);
        }
    }
}

// Usage
public class DocumentApp {
    public static void main(String[] args) {
        openDocument("example.docx");
        openDocument("report.xlsx");
        openDocument("manual.pdf");
    }

    private static void openDocument(String filename) {
        try {
            Document document = DocumentFactory.createDocument(filename);
            document.open(filename);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
