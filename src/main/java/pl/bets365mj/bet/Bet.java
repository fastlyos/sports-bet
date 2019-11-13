package pl.bets365mj.bet;

import lombok.Getter;
import lombok.Setter;
import pl.bets365mj.coupon.Coupon;
import pl.bets365mj.fixture.Fixture;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;


@Entity
public class Bet implements Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @Getter @Setter
    private Fixture fixture;

    @Getter @Setter
    private String placedBet;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Date dateCreated;

    @Getter @Setter
    private boolean won;

    @Getter @Setter
    private BigDecimal betPrice;

    @ManyToOne
    @Getter @Setter
    private Coupon coupon;

    public Bet() {
        setDateCreated();
    }

    private void setDateCreated() {
        Date date=new Date();
        this.dateCreated = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet singleBet = (Bet) o;
        return Objects.equals(fixture, singleBet.fixture);
    }

    public boolean checkIfUniqe(List<Bet> bets){
        if (bets!=null){
            for( Bet b:bets){
                int x= this.getFixture().getId();
                int y= b.getFixture().getId();
                if (x == y){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fixture);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}

