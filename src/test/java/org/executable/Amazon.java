package org.executable;

import java.io.IOException;

import org.base.Base;
import org.pojo.classes.HomePojo;
import org.pojo.classes.LoginPojo;
import org.pojo.classes.ProductPojo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Amazon extends Base {

	@BeforeClass
	private void loadBrowser() throws InterruptedException {
		chrome();
		launchUrl(
				"https://www.amazon.in/ap/signin?_encoding=UTF8&accountStatusPolicy=P1&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fmessage#!/inbox");

		maxWindow();
		Thread.sleep(3000);
	}

	@Test
	private void tc1() throws InterruptedException, IOException {

		implisitWait();
		LoginPojo l = new LoginPojo();
		findAndSend(l.getEmail(), readExcel(2, 0));
		clickAny(l.getConti());
		findAndSend(l.getPassword(), readExcel(2, 1));
		clickAny(l.getLogin());

	}

	@Test
	private void tc2() throws IOException, InterruptedException {
		
		implisitWait();
		HomePojo h = new HomePojo();
		findAndSend(h.getSearchTxt(), readExcel(2, 2));
		clickAny(h.getSearchBtn());
		Thread.sleep(3000);

	}

	@Test
	private void tc3() {
		
		implisitWait();
		ProductPojo p = new ProductPojo();
		clickAny(p.getSamsung());
		windowHand();
		clickAny(p.getAddToCart());
		located();
		clickAny(p.getCheckOut());

	}
	
	

}
