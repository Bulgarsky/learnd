class Order<OID,UID,S> {
    private OID orderId;
    private UID userId;
    private S status;
    //constructor
    Order(OID orderId, UID userId, S status) {
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
    public S getStatus() {
        return status;
    }

    //setters
    public void setStatus(S status) {
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

