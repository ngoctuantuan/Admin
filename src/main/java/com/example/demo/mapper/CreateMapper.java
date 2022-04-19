package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.AdminTuanEntity;
import com.example.demo.model.CreateModel;
import com.example.demo.model.DeleteModel;
import com.example.demo.model.EditModel;
import com.example.demo.model.SearchModel;

@Mapper
public interface CreateMapper {

	void createUser(CreateModel createModel);

	int checkLogin(CreateModel createModel);

	List<AdminTuanEntity> getAllUser();
	
	void deleteUser(DeleteModel deleteModel);

	void edit(EditModel editModel);

	List<AdminTuanEntity> searchuser(SearchModel searchModel);

}
