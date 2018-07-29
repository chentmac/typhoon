package dao.impl;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AdDao;
import pojo.Ad;
import util.DBUtil;


public class AdDaoImpl implements AdDao{

	@Override
	public List<Ad> getAllAd() {
		List<Ad> ads=new ArrayList<Ad>();
		String sql="select id,shop_id,shop_name,picture,slogan,price,state,time from ad";
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				Integer id= rs.getInt("id");
				String shopId=rs.getString("shop_id");
				String shopName=rs.getString("shop_name");
				String picture=rs.getString("picture");
				String slogan=rs.getString("slogan");
				double price =rs.getDouble("price");
				Integer state=rs.getInt("state");
				Date time=rs.getDate("time");
				Ad ad=new Ad(id,shopId,shopName,picture,slogan,price,state,time);
				ads.add(ad);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pst, rs);
		}
		return ads;
	}

	@Override
	public int updateAd(Ad ad) {
		String sql="update ad set state=? where id=?";
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		int result = 0;
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, ad.getState());;
			pst.setInt(2, ad.getId());
			result=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pst, null);
		}
		return result;
	}

	@Override
	public int addAd(Ad ad) {
		String sql="insert into ad(id,shop_id,shop_name,picture,slogan,price,time) values(seqAdmin.nextval,?,?,?,?,?,sysdate)";
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		int result = 0;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, ad.getShopId());
			pst.setString(2, ad.getShopName());
			pst.setString(3, ad.getPicture());
			pst.setString(4, ad.getSlogan());
			pst.setDouble(5, ad.getPrice());
			result=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pst,null);
		}
		return result;
	}

	@Override
	public List<Ad> sendAds() {
		List<Ad> ads=new ArrayList<Ad>();
		String sql="select id,shop_id,shop_name,picture,slogan,price,state,time from ad where state=1 and rownum <=3 order by id desc ";
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				Integer id= rs.getInt("id");
				String shopId=rs.getString("shop_id");
				String shopName=rs.getString("shop_name");
				String picture=rs.getString("picture");
				String slogan=rs.getString("slogan");
				double price =rs.getDouble("price");
				Integer state=rs.getInt("state");
				Date time=rs.getDate("time");
				Ad ad=new Ad(id,shopId,shopName,picture,slogan,price,state,time);
				ads.add(ad);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pst, rs);
		}
		return ads;
	}

	@Override
	public int deleteAdById(int id) {
		String sql="delete from ad where id=?";
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		int result = 0;
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			result=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pst,null);
		}
		return result;
	}

	@Override
	public int findAdsCount() {
		String sql="select count(*) from ad";
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
	public List<Ad> getAdByPage(int begin, int end) {
		String sql="select * from(select A.*,ROWNUM RN FROM(SELECT * FROM AD)A WHERE ROWNUM<=?)WHERE RN>?";
		List<Ad> ads=new ArrayList<Ad>();
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,end);
			pst.setInt(2,begin);
			rs=pst.executeQuery();
			while(rs.next()) {
				Integer id= rs.getInt("id");
				String shopId=rs.getString("shop_id");
				String shopName=rs.getString("shop_name");
				String picture=rs.getString("picture");
				String slogan=rs.getString("slogan");
				double price =rs.getDouble("price");
				Integer state=rs.getInt("state");
				Date time=rs.getDate("time");
				Ad ad=new Ad(id,shopId,shopName,picture,slogan,price,state,time);
				ads.add(ad);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pst, rs);
		}
		return ads;
	}


	
}
