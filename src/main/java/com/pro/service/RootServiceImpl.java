package com.pro.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pro.domain.Root;
import com.pro.mapper.RootMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RootServiceImpl implements RootService {
    @Autowired
    private RootMapper rootMapper;
    @Override
    public String login(Root root) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",root.getUsername());
        Root rt = rootMapper.selectOne(queryWrapper);
        if (rt!=null){
            if (rt.getPassword()!=""&&rt.getPassword()!=null){
                if (rt.getPassword().equals(root.getPassword())){
                    return "index";
                }
            }
        }
        return "no";
    }
}
