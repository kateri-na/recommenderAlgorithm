package com.recommender.recommenderAlgorithm.services;

import com.recommender.recommenderAlgorithm.models.NormalizedRatings;
import com.recommender.recommenderAlgorithm.models.Ratings;
import com.recommender.recommenderAlgorithm.models.Similarities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PersonalRecommendationsService {
    private final RatingsService ratingsService;
    private final UserService userService;
    private final SimilarityService similarityService;
    private final NormalizedRatingsService normalizedRatingsService;
    @Autowired
    public PersonalRecommendationsService(RatingsService ratingsService, UserService userService,
                                          SimilarityService similarityService,
                                          NormalizedRatingsService normalizedRatingsService) {
        this.ratingsService = ratingsService;
        this.userService = userService;
        this.similarityService = similarityService;
        this.normalizedRatingsService = normalizedRatingsService;
    }
    public List<Ratings> predictedRatings(){
        List<Ratings> predictedRatings = new LinkedList<Ratings>();
        List<Ratings> serialsWithoutRatings = ratingsService.getZeroRatings();
        for (Ratings serialRating:serialsWithoutRatings){
            List<Similarities> ratingNeighborhood = similarityService.getNeighborhood(serialRating.getSerialId(),
                    0.5);
            double predictedRating = regressionFormula(ratingNeighborhood, serialRating.getUserId(),serialRating.getSerialId());
            predictedRatings.add(new Ratings(serialRating.getUserId(),serialRating.getSerialId(),predictedRating));
        }
        return predictedRatings;
    }

    public void calculateSimilarity(){
        for (Integer i=1; i<10; ++i){
            for(Integer j = i+1; j<=10; ++j) {
                List<Ratings> column1 = ratingsService.getAllSerialRatings(i.longValue());
                List<Ratings> column2 = ratingsService.getAllSerialRatings(j.longValue());
                similarityService.addSimilarity(i, j, similarityFormula(column1, column2));
            }
        }
    }

    public void normalizeRatings(){
        List<Integer> usersIds = userService.getUsersIds();
        double averageRating = 0.0;
        for(int i =0; i<usersIds.size(); ++i){
            List<Ratings> userRatings = ratingsService.getAllUserRatings(usersIds.get(i).longValue());
            averageRating = calculateAverage(userRatings);
            for(Ratings rating :userRatings){
                if(rating.getRatingValue() != 0) {
                    //ratingsService.updateRating(rating.getUserId(), rating.getSerialId(),rating.getRatingValue() - averageRating);
                    normalizedRatingsService.addNormalizedRating(rating.getUserId(), rating.getSerialId(),
                            rating.getRatingValue() - averageRating);
                }
                else{
                    normalizedRatingsService.addNormalizedRating(rating.getUserId(), rating.getSerialId(), 0.0);
                }
            }
        }
    }
    private double calculateAverage(List<Ratings> ratings){
        int count = 0;
        double result = 0.0;
        for(int i =0; i<ratings.size(); ++i){
            if(ratings.get(i).getRatingValue() != 0.0){
                ++count;
                result +=ratings.get(i).getRatingValue();
            }
        }
        return result/count;
    }
    private double similarityFormula(List<Ratings> column1, List<Ratings> column2){
        double numerator = 0.0;
        double denominator1 = 0.0;
        double denominator2 = 0.0;
        for(int i=1; i< column1.size(); ++i){
            numerator += (column1.get(i).getRatingValue() * column2.get(i).getRatingValue());
            denominator1 += Math.pow(column1.get(i).getRatingValue(),2);
            denominator2 += Math.pow(column2.get(i).getRatingValue(),2);
        }
        return numerator/(Math.sqrt(denominator1)*Math.sqrt(denominator2));
    }
    private double regressionFormula(List<Similarities> neighborhood, Long userId, Long predictedSerialId){
        double average = calculateAverage(ratingsService.getAllUserRatings(userId.longValue()));
        double numerator= 0.0;
        double denominator = 0.0;
        for(Similarities similarity : neighborhood){
            Integer comparableSerialId = pairSimilarityMatrixId(similarity,predictedSerialId);
            numerator += similarity.getSimilarity() * ratingsService.getCertainSerialRating(userId.longValue(),
                    comparableSerialId.longValue()).getRatingValue();
            denominator += similarity.getSimilarity();
        }
        return average + numerator/denominator;
    }
    private int pairSimilarityMatrixId(Similarities similarity, Long predictedSerialId){
        if(similarity.getSerialRowId().equals(predictedSerialId.intValue())){
            return similarity.getSerialColumnId();
        }
        else{
            return similarity.getSerialRowId();
        }
    }
}
