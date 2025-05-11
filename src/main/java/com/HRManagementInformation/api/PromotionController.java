package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IPromotionService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.promotion.PromotionSaveRequest;
import com.HRManagementInformation.dto.request.promotion.PromotionUpdateRequest;
import com.HRManagementInformation.dto.response.PromotionResponse;
import com.HRManagementInformation.entities.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/promotion")
public class PromotionController {
    @Autowired
    private final IPromotionService promotionService;
    @Autowired
    private final IModelMapperService modelMapperService;

    public PromotionController(IPromotionService promotionService, IModelMapperService modelMapperService) {
        this.promotionService = promotionService;
        this.modelMapperService = modelMapperService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<PromotionResponse>> getAllPromotion(){
        List<Promotion> promotionList = this.promotionService.getAll();
        List<PromotionResponse> promotionResponses = promotionList.stream()
                .map(promotion -> this.modelMapperService.forResponse().map(promotion, PromotionResponse.class))
                .collect(Collectors.toList());
        return ResultHelper.success(promotionResponses);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PromotionResponse> getPromotionById(@PathVariable("id") int id){
        Promotion promotion = this.promotionService.get(id);

        return ResultHelper.success(this.modelMapperService.forResponse().map(promotion, PromotionResponse.class));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<PromotionResponse> createPromotion(@RequestBody PromotionSaveRequest promotionSaveRequest){
        Promotion savePromotion = this.modelMapperService.forRequest().map(promotionSaveRequest,Promotion.class);
        return ResultHelper.created(this.modelMapperService.forResponse().map(savePromotion, PromotionResponse.class));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PromotionResponse>
    updatePromotion(@PathVariable("id") int id,
                    @RequestBody PromotionUpdateRequest promotionUpdateRequest){
        Promotion promotion = this.promotionService.get(id);
        this.modelMapperService.forRequest().map(promotionUpdateRequest, promotion);
        this.promotionService.update(promotion);

        return ResultHelper.updated(this.modelMapperService.forResponse().map(promotion, PromotionResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deletePromotion(@PathVariable("id") int id){
        Promotion promotion = this.promotionService.get(id);
        promotionService.delete(promotion.getPromotionId());
        return ResultHelper.deleted();
    }



}



















