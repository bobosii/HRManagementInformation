package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IPromotionService;
import com.HRManagementInformation.dao.PromotionRepository;
import com.HRManagementInformation.entities.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionManager implements IPromotionService {
    @Autowired
    private final PromotionRepository promotionRepository;

    public PromotionManager(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public Promotion save(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public Promotion get(int id) {
        return promotionRepository.findById(id).orElseThrow();
    }

    @Override
    public Promotion update(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public List<Promotion> getAll() {
        return promotionRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        Promotion promotion = this.get(id);
        promotionRepository.delete(promotion);
        return true;
    }
}
