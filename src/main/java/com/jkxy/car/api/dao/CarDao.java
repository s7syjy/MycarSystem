package com.jkxy.car.api.dao;

import com.jkxy.car.api.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CarDao {
    @Select("select * from carInformation")
    List<Car> findAll();

    @Select("select * from carInformation where id = #{id}")
    Car findById(int id);

    @Select("select * from carInformation where carName = #{carName}")
    List<Car> findByCarName(String carName);

    @Delete("delete from carInformation where id = #{id}")
    void deleteById(int id);

    @Update("update carInformation set carName=#{carName},carType=#{carType},price=#{price},carSeries=#{carSeries},inventory=#{inventory} where id = #{id}")
    void updateById(Car car);

    @Insert("insert into carInformation(carName,carType,price,carSeries,inventory) values(#{carName},#{carType},#{price},#{carSeries},#{inventory}),")
    void insertCar(Car car);

    @Select("select * from carInformation where carName LIKE #{brand}")
    List<Car> findCarBrand(String brand);

    @Update("update carInformation set inventory=#{inventory} where id = #{id}")
    void upgradeInventory(int id,int inventory);
}
