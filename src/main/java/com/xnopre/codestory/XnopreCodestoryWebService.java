package com.xnopre.codestory;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;

import org.simpleframework.http.core.Container;
import org.simpleframework.transport.connect.SocketConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.AbstractService;

public class XnopreCodestoryWebService extends AbstractService {

	private final Logger logger = LoggerFactory
			.getLogger(XnopreCodestoryWebService.class);

	private final int port;
	private SocketConnection socketConnection;

	private final Container controller;

	public XnopreCodestoryWebService(int port, Container controller) {
		this.port = port;
		this.controller = controller;
	}

	@Override
	protected void doStart() {
		String s = "A:/aa.txt";
		new File(s);
		try {
			socketConnection = new SocketConnection(controller);
			socketConnection.connect(new InetSocketAddress(port));
			notifyStarted();
			logger.info("service started !");
		} catch (IOException e) {
			logger.error("eror starting service", e);
			notifyFailed(e);
		}
	}

	@Override
	protected void doStop() {
		try {
			socketConnection.close();
			notifyStopped();
			logger.info("service stopped !");
		} catch (IOException e) {
			logger.error("eror stopping service", e);
			notifyFailed(e);
		}
	}

}
