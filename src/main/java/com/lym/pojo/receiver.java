package com.lym.pojo;

public class receiver {
	private String titol;
	private String producer;
	private String type;
	private String receive;
	private String reProducer;
	private String readCount;
	private String receiveCount;
	
	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReceive() {
		return receive;
	}

	public void setReceive(String receive) {
		this.receive = receive;
	}

	public String getReProducer() {
		return reProducer;
	}

	public void setReProducer(String reProducer) {
		this.reProducer = reProducer;
	}

	public String getReadCount() {
		return readCount;
	}

	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}

	public String getReceiveCount() {
		return receiveCount;
	}

	public void setReceiveCount(String receiveCount) {
		this.receiveCount = receiveCount;
	}

	@Override
	public String toString() {
		return "reciver [titol=" + titol + ", producer=" + producer + ", type=" + type + ", receive=" + receive
				+ ", reProducer=" + reProducer + ", readCount=" + readCount + ", receiveCount=" + receiveCount + "]";
	}
}
