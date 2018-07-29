package service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import dao.AdDao;
import dao.MerchantDao;
import dao.impl.AdDaoImpl;
import dao.impl.MerchantDaoImpl;
import pojo.Ad;
import pojo.Merchant;
import service.JMSService;
import util.ImgUtil;
import util.JsonParse;
import util.JsonParseByJackson;

public class JMSServiceImpl implements JMSService {
	 private AdDao adDao=new AdDaoImpl();
	 private MerchantDao merchantDao=new MerchantDaoImpl();
	 OutputStream out=null;
	@Override
	public void addMerchant(MessageConsumer consumer,String path) throws JMSException {
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message arg0) {
				TextMessage msg=(TextMessage)arg0;
				try {
					JsonParse<Merchant> jsonUtil=new JsonParseByJackson<>();
					Merchant merchant=jsonUtil.parseJsonToObject(Merchant.class,msg.getText());
					//驳回信息改回待审核，并更新状态
					Merchant merchant2=merchantDao.getMerchantByShopId(merchant.getShopId());
					if(merchant2.getShopId()!=null&&merchant2.getStatus()==2) {
						merchantDao.deleteMerchantByShopId(merchant2.getShopId());
					}
					//防止店铺名重复
					Merchant merchant1=merchantDao.checkMerchantByIdCard(merchant.getIdCard());
					if (merchant.getShopName().equals(merchant1.getShopName())) {
						merchant.setStatus(2);
					}
					
					String picture=merchant.getPicture();
					String picName="/merchant/"+merchant.getShopId()+".jpg";
					String src=path+picName;
					out=new FileOutputStream(src);
					out.write(ImgUtil.string2Img(picture));
					out.flush();
					merchant.setPicture("/team_typhoon_admin"+picName);
					merchantDao.addMerchant(merchant);
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
	}

	@Override
	public void addAd(MessageConsumer consumer,String path) throws JMSException {
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message arg0) {
				TextMessage msg=(TextMessage)arg0;
				try {
					JsonParse<Ad> jsonUtil=new JsonParseByJackson<>();
					Ad ad=jsonUtil.parseJsonToObject(Ad.class, msg.getText());
//					ObjectMapper mapper=new ObjectMapper();
//					Ad ad=mapper.readValue(msg.getText().getBytes("utf-8"),Ad.class);
					String picture=ad.getPicture();
					String picName="/ad/"+ad.getShopId()+".jpg";
					String src=path+picName;
					out=new FileOutputStream(src);
					out.write(ImgUtil.string2Img(picture));
					out.flush();
					ad.setPicture("/team_typhoon_admin"+picName);
					adDao.addAd(ad);
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}