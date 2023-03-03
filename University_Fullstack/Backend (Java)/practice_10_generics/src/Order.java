class Order<OID,UID,C> {
    private OID orderId;
    private UID userId;
    private C status;
    //constructor
    Order(OID orderId, UID userId, C status) {
    this.orderId = orderId;
    this.userId = userId;
    this.status = status;
    }
    //getters
    public OID getOrderId() {
        return orderId;
    }
    public UID getUserId() {
        return userId;
    }
    public C getStatus() {
        return status;
    }

    //setters
    public void setStatus(C status) {
          this.status = status;
    }

    //methods
    public void printInfo(){
        System.out.println("order: "+getOrderId()+", user: "+getUserId()+", status: "+getStatus());
    }
    public void typesInfo() {
        System.out.println(
                getOrderId()+": "+orderId.getClass().getName()+"\n"
                +getUserId()+": "+userId.getClass().getName()+"\n"
                +getStatus()+": "+status.getClass().getName());
        System.out.println("---------");
    }
}

