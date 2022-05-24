package case_study.modules;

import java.util.Date;

public class Booking {
    private int bookingCode;
    private Date startDate;
    private Date endDate;
    private int customerCode;
    private String nameService;
    private String serviceType;

    public Booking(){

    }

    public Booking(int bookingCode, Date startDate, Date endDate, int customerCode, String nameService, String serviceType) {
        this.bookingCode = bookingCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerCode = customerCode;
        this.nameService = nameService;
        this.serviceType = serviceType;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getInfor(){
        return "Booking: " +
                "bookingCode= " + bookingCode +
                ", startDate= " + startDate +
                ", endDate= " + endDate +
                ", customerCode=" + customerCode +
                ", nameService= " + nameService +
                ", serviceType= " + serviceType;
    }

    @Override
    public String toString() {
        return this.getBookingCode() + ", " + this.getStartDate() + ", " + this.getEndDate() + ", " +
                this.getCustomerCode()+ ", " + this.getNameService() + ", " + this.getServiceType();
    }
}

