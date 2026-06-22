package solidprinciple;

public class OCPgood {

}


interface InvoiceSaver {
    void save(Invoice invoice);
}

class DatabaseSaver implements InvoiceSaver {
    public void save(Invoice invoice) {
        // DB logic
    }
}

class FileSaver implements InvoiceSaver {
    public void save(Invoice invoice) {
        // File logic
    }
}

// Tomorrow — S3Saver? Just add a new class. Touch NOTHING existing.
class S3Saver implements InvoiceSaver {
    public void save(Invoice invoice) {
        // S3 logic
    }
}