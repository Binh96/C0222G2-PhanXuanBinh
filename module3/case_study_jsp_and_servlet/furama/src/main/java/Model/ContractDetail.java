package Model;

import java.util.Date;

public class ContractDetail {
    private int id;
    private int contractId;
    private int serviceId;
    private int quantity;

    public ContractDetail() {

    }

    public ContractDetail(int id, int contractId, int serviceId, int quantity) {
        this.id = id;
        this.contractId = contractId;
        this.serviceId = serviceId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
