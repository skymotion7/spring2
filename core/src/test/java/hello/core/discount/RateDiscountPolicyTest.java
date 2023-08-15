package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP 할인이 정확히 됐는가?")
    void vip_o(){
        Member member = new Member(1L, "mem1", Grade.VIP);
        int discout = rateDiscountPolicy.discount(member, 10000);
        Assertions.assertThat(discout).isEqualTo(1000);

    }
    @Test
    @DisplayName("BASIC 할인이 적용됐는가?")
    void vip_x(){
        Member member = new Member(2L, "mem1", Grade.BASIC);
        int discout = rateDiscountPolicy.discount(member, 10000);
        Assertions.assertThat(discout).isEqualTo(0);

    }

}