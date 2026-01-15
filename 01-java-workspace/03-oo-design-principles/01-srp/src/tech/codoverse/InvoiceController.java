package tech.codoverse;

public class InvoiceController {

    private final InvoiceRepository repo;

    public InvoiceController() {
        repo = new InvoiceRepository();
    }

    public void save(Invoice invoice) {
        repo.save(invoice);
    }

}
