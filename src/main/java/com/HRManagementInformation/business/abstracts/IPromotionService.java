package com.HRManagementInformation.business.abstracts;


import com.HRManagementInformation.entities.Promotion;

import java.util.List;

public interface IPromotionService {
    Promotion save(Promotion promotion);
    Promotion get(int id);
    Promotion update(Promotion promotion);
    List<Promotion> getAll();
    boolean delete(int id);
}
