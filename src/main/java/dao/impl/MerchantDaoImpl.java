package dao.impl;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.crypto.provider.RSACipher;

import dao.MerchantDao;
import pojo.Ad;
import pojo.Merchant;
import util.DBUtil;


public class MerchantDaoImpl implements MerchantDao {

	
	
	@Override
	public Merchant getMerchantById(String id) {
		Merchant merchant=new Merchant();
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select * from merchant where id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1,id);
			rs=pst.executeQuery();
			while(rs.next()){
				merchant.setAddress(rs.getString("address"));
				merchant.setComments(rs.getString("comments"));
				merchant.setCorporateName(rs.getString("corporate_name"));
				merchant.setCreditCode(rs.getString("credit_code"));
				merchant.setShopId(rs.getString("id"));
				merchant.setIdCard(rs.getString("id_card"));
				merchant.setPhone(rs.getString("phone"));
				merchant.setPicture(rs.getString("picture"));
				merchant.setShopName(rs.getString("shop_name"));
				merchant.setStatus(rs.getInt("status"));
				merchant.setVersion(rs.getInt("version"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pst, rs);
		}
		return merchant;
	}
	
	
	@Override
	public int updateMerchant(Merchant merchant) {
		int result=0;
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="update merchant set credit_code=?,id_card=?,corporate_name=?,picture=?,phone=?,shop_name=?"
					+ ",address=?,status=?,comments=?,version=? where id=? and version=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1,merchant.getCreditCode());
			pst.setString(2,merchant.getIdCard());
			pst.setString(3,merchant.getCorporateName());
			pst.setString(4,merchant.getPicture());
			pst.setString(5,merchant.getPhone());
			pst.setString(6,merchant.getShopName());
			pst.setString(7,merchant.getAddress());
			pst.setInt(8,merchant.getStatus());
			pst.setString(9,merchant.getComments());
			pst.setInt(10,merchant.getVersion()+1);
			pst.setString(11,merchant.getShopId());
			pst.setInt(12,merchant.getVersion());
			result=pst.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pst, rs);
		}
		return result;
	}

	@Override
	public int addMerchant(Merchant merchant) {
		int result=0;
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="insert into merchant(id,credit_code,id_card,corporate_name,picture,phone,shop_name,address,comments,version) values(?,?,?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1,merchant.getShopId());
			pst.setString(2,merchant.getCreditCode());
			pst.setString(3,merchant.getIdCard());
			pst.setString(4,merchant.getCorporateName());
			pst.setString(5,merchant.getPicture());
			pst.setString(6,merchant.getPhone());
			pst.setString(7,merchant.getShopName());
			pst.setString(8,merchant.getAddress());
			pst.setString(9,merchant.getComments());
			pst.setInt(10,1);
			result=pst.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pst, rs);
		}
		return result;
	}


	@Override
	public List<Merchant> getAllMerchant() {
		List<Merchant> merchants=new ArrayList<>();
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select * from merchant";
			pst = conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Merchant merchant=new Merchant();
				merchant.setAddress(rs.getString("address"));
				merchant.setComments(rs.getString("comments"));
				merchant.setCorporateName(rs.getString("corporate_name"));
				merchant.setCreditCode(rs.getString("credit_code"));
				merchant.setShopId(rs.getString("id"));
				merchant.setIdCard(rs.getString("id_card"));
				merchant.setPhone(rs.getString("phone"));
				merchant.setPicture(rs.getString("picture"));
				merchant.setShopName(rs.getString("shop_name"));
				merchant.setStatus(rs.getInt("status"));
				merchants.add(merchant);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pst, rs);
		}
		return merchants;
	}


	@Override
	public Merchant checkMerchantByIdCard(String idCard) {
		Merchant merchant=new Merchant();
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select * from merchant where id_card=? and status<>2";
			pst = conn.prepareStatement(sql);
			pst.setString(1,idCard);
			rs=pst.executeQuery();
			while(rs.next()){
				merchant.setAddress(rs.getString("address"));
				merchant.setComments(rs.getString("comments"));
				merchant.setCorporateName(rs.getString("corporate_name"));
				merchant.setCreditCode(rs.getString("credit_code"));
				merchant.setShopId(rs.getString("id"));
				merchant.setIdCard(rs.getString("id_card"));
				merchant.setPhone(rs.getString("phone"));
				merchant.setPicture(rs.getString("picture"));
				merchant.setShopName(rs.getString("shop_name"));
				merchant.setStatus(rs.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pst, rs);
		}
		return merchant;
	}


	@Override
	public Merchant getMerchantByShopId(String shopId) {
		Merchant merchant=new Merchant();
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select * from merchant where id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1,shopId);
			rs=pst.executeQuery();
			while(rs.next()){
				merchant.setAddress(rs.getString("address"));
				merchant.setComments(rs.getString("comments"));
				merchant.setCorporateName(rs.getString("corporate_name"));
				merchant.setCreditCode(rs.getString("credit_code"));
				merchant.setShopId(rs.getString("id"));
				merchant.setIdCard(rs.getString("id_card"));
				merchant.setPhone(rs.getString("phone"));
				merchant.setPicture(rs.getString("picture"));
				merchant.setShopName(rs.getString("shop_name"));
				merchant.setStatus(rs.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pst, rs);
		}
		return merchant;
	}


	@Override
	public int deleteMerchantByShopId(String shopId) {
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		int result=0;
		try {
			String sql="delete from merchant where id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, shopId);
			result=pst.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pst, null);
		}
		return result;
	}



	@Override
	public List<Merchant> getNoCheckMerchantByPage(int begin, int end) {
		String sql="select * from(select A.*,ROWNUM RN FROM(SELECT * FROM MERCHANT WHERE STATUS=0)A WHERE ROWNUM<=?)WHERE RN>?";
		List<Merchant> merchants=new ArrayList<Merchant>();
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,end);
			pst.setInt(2,begin);
			rs=pst.executeQuery();
			while(rs.next()) {
				String id=rs.getString("id");
				String creditCode=rs.getString("credit_code");
				String idCard=rs.getString("id_card");
				String corporateName=rs.getString("CORPORATE_NAME");
				String picture=rs.getString("PICTURE");
				String phone=rs.getString("PHONE");
				String shopName=rs.getString("shop_name");
				String address=rs.getString("address");
				int status=rs.getInt("status");
				String comments=rs.getString("comments");
				Merchant merchant=new Merchant(id, creditCode, idCard, corporateName, picture, phone, shopName, address, status, comments);
				merchants.add(merchant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pst, rs);
		}
		return merchants;
	}


	@Override
	public int findNoCheckMerchantCount() {
		String sql="select count(*) from merchant where status=0";
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		int count = 0;
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
			pst=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pst,null);
		}
		return count;
	}


	@Override
	public int findAgreeMerchantCount() {
		String sql="select count(*) from merchant where status=1";
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		int count = 0;
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
			pst=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pst,null);
		}
		return count;
	}


	@Override
	public List<Merchant> getAgreeMerchantByPage(int begin, int end) {
		String sql="select * from(select A.*,ROWNUM RN FROM(SELECT * FROM MERCHANT WHERE STATUS=1)A WHERE ROWNUM<=?)WHERE RN>?";
		List<Merchant> merchants=new ArrayList<Merchant>();
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,end);
			pst.setInt(2,begin);
			rs=pst.executeQuery();
			while(rs.next()) {
				String id=rs.getString("id");
				String creditCode=rs.getString("credit_code");
				String idCard=rs.getString("id_card");
				String corporateName=rs.getString("CORPORATE_NAME");
				String picture=rs.getString("PICTURE");
				String phone=rs.getString("PHONE");
				String shopName=rs.getString("shop_name");
				String address=rs.getString("address");
				int status=rs.getInt("status");
				String comments=rs.getString("comments");
				Merchant merchant=new Merchant(id, creditCode, idCard, corporateName, picture, phone, shopName, address, status, comments);
				merchants.add(merchant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pst, rs);
		}
		return merchants;
	}


	@Override
	public int findDisagreeMerchantCount() {
		String sql="select count(*) from merchant where status=3";
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		int count = 0;
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
			pst=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pst,null);
		}
		return count;
	}


	@Override
	public List<Merchant> getDisagreeMerchantByPage(int begin, int end) {
		String sql="select * from(select A.*,ROWNUM RN FROM(SELECT * FROM MERCHANT WHERE STATUS=3)A WHERE ROWNUM<=?)WHERE RN>?";
		List<Merchant> merchants=new ArrayList<Merchant>();
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,end);
			pst.setInt(2,begin);
			rs=pst.executeQuery();
			while(rs.next()) {
				String id=rs.getString("id");
				String creditCode=rs.getString("credit_code");
				String idCard=rs.getString("id_card");
				String corporateName=rs.getString("CORPORATE_NAME");
				String picture=rs.getString("PICTURE");
				String phone=rs.getString("PHONE");
				String shopName=rs.getString("shop_name");
				String address=rs.getString("address");
				int status=rs.getInt("status");
				String comments=rs.getString("comments");
				Merchant merchant=new Merchant(id, creditCode, idCard, corporateName, picture, phone, shopName, address, status, comments);
				merchants.add(merchant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pst, rs);
		}
		return merchants;
	}

}
