package com.hashworks.GobalOrderVisibility.serviceImpl;


import com.hashworks.GobalOrderVisibility.model.*;
import com.hashworks.GobalOrderVisibility.repository.TrackOrderRepository;
import com.hashworks.GobalOrderVisibility.service.TrackOrderService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.*;

/**
 * Created by Preetesh on 7/10/2017.
 */
@Service
public class TrackOrderServiceImpl implements TrackOrderService{


    @Autowired
    public TrackOrderRepository trackOrderRepository;

    @Override
    public Map listTrackOrder(String  listSetUp) {
      /*  *//*EntityManager em;
        EntityManagerFactory emf;*/


        Map responseMap = new LinkedHashMap();
        List<TrackOrder> responseList = new ArrayList<TrackOrder>();


      //  String str = this.getWhereClause(listSetUp);
      // System.out.print("Where clause is :" + str);


        try {

            System.out.println("Result list :" + responseList);
            responseList = this.trackOrderRepository.findAllByTrackOrderId(/*str*/);
          //  responseList = this.trackOrderRepository.findAllByTrackOrderId();
            System.out.println("Result list :" + responseList);

            responseMap.put("trackOrder", responseList);
            responseMap.put("status", "Success");

            return responseMap;
        } catch (Exception e) {
            e.printStackTrace();
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            return responseMap;
        }
    }




      /* try{

           emf= Persistence.createEntityManagerFactory("jpa-mysql-pu");
           em=emf.createEntityManager();
           javax.persistence.Query query  = em.createNativeQuery(str, TrackOrder.class);
           query.setMaxResults(30);
           responseList = (List<TrackOrder>)query.getResultList();

     *//* SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
        Query query = session.createSQLQuery(str).addEntity("t",TrackOrder.class).addEntity("b",BusinessUnit.class).addEntity("l", LOB.class).addEntity("o", OrderDetails.class).addEntity("r", Region.class);


        System.out.println("Query is : " + query);

       // responseList = (query.setResultTransformer(Transformers.aliasToBean(TrackOrder.class))).list();
            responseList = query.list();

            System.out.println("Response List is : " +responseList );
System.out.println("Sql result: " + responseList);
        Map resultToMap = new HashMap<String,Object>();
        List resultList = new ArrayList<TrackOrder>();
        for(TrackOrder t : responseList){



        resultToMap.put("trackOrderId",t.getTrackOrderId());
        resultToMap.put("tieNumber",t.getTieNumber());
        resultToMap.put("businessUnit",t.getBusinessUnit());
            resultToMap.put("lob",t.getLob());
            resultToMap.put("orderDetails",t.getOrderDetails());
            resultToMap.put("region",t.getRegion());
            resultList.add(resultToMap);

        }


        System.out.println("Total rows = "+responseList.size());*//*

         responseMap.put("trackOrder", responseList);
         responseMap.put("status", "success");
           em.close();
           emf.close();

         return responseMap;
     }catch (Exception e) {
     e.printStackTrace();
        responseMap.put("status", "Bad Request" );
        return responseMap;*/


   // }/*finally{

           // session.close();
      //  }*/
   // }

    private String getWhereClause(String jsonString){
        JSONObject jsonObject = new JSONObject(jsonString);
      Set jsonKeySet = jsonObject.keySet();

        Iterator<String> iter = jsonKeySet.iterator();
System.out.println("before sql");

/*t.tie_number,b.business_unit_id,b.business_unit_name,l.lob_id,l.lobs_name,r.region_id,r.region_name,r.region_code*///   String stringSQL = "select t.track_order_id  ,t.tie_number ,t.business_unit_id,b.business_unit_name,t.lob_id,l.lobs_name,t.order_details_id,o.customer_number,t.region_id,r.region_name  from track_order t  where JOIN business_unit b ON t.business_unit_id = b.id join lob l ON t.lob_id = l.id join region r on t.region_id = r.id";

        //String stringSQL = "select t.tie_number,b.business_unit_id,b.business_unit_name,l.lob_id,l.lobs_name,r.region_id,r.region_name,r.region_code from track_order t join business_unit b on t.business_unit_id = b.id join lob l on t.lob_id = l.id join order_detail o on t.order_details_id = o.id join region r on t.region_id = r.id where ";
        String value = null;

        String stringSQL = "";

        while (iter.hasNext()) {

             boolean flag = true;
            String key = null;

            key = iter.next();


            //  List keyList = new ArrayList<String>();
if((iter.hasNext() == false)){
    flag = false;

}

            Object objectValue = jsonObject.get(key);
            value = objectValue.toString().replace('[', ' ').replace(']', ' ');
/*            if(key.equalsIgnoreCase("tie_number"))key = "t."+key;
            if(key.equalsIgnoreCase("business_unit_id"))key = "t."+ key;
            if(key.equalsIgnoreCase("region_id"))key = "t."+key;*/


            if (flag) {
           /* if(key.equalsIgnoreCase("tie_number"))key = "t."+key;

               if(key.equalsIgnoreCase("business_unit_id"))key = "t."+ key;*/
          stringSQL = stringSQL.concat("t." + key + " IN (" + value + " ) AND ");

            }else{
                String lastElement = "t." + key + " IN (" + value + " )";
                stringSQL = stringSQL.concat(lastElement);
            }
            System.out.println("sql 1 is : " + stringSQL);
        }

return stringSQL ;
    }
/*

    public List<TrackOrder> findAllByCustomizedId(String query){


    }
*/

   /* public List<TrackOrder> getResultList(String str){



        TypedQuery query = em.createQuery(str,TrackOrder.class);

        System.out.println("Inside getResultList" + query.getResultList()+ "query is " + query );

        return query.getResultList();



    }*/


}

