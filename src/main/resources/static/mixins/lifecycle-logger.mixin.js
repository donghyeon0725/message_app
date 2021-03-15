/**
 * 믹스인
 *
 * 믹스인이란 프로토타입을 바꾸지 않고 한 객체의 프로퍼티를 다른 객체에게 ‘복사’해서 사용하는 방식
 * 라이프 사이클을 추적하기 위해 생명주기를 직접 컴포넌트에 주는 것도 방법이지만,
 * 믹스인을 사용해서 모듈에 한 두줄만 추가해서 계속 사용할 수도 있다.
 *
 * 사용법
 *
 * mixins             : [모듈이름] 프로퍼티를 통해서 추가한다.
 * ${this.$options}   : 를 통해서 생성된 모듈의 인스턴스에 접근 가능
 * */
export default {
  created () {
    console.log(`${this.$options.name} created`)
  },
  beforeMount () {
    console.log(`${this.$options.name} about to mount`)
  },
  mounted () {
    console.log(`${this.$options.name} mounted`)
  },  
  destroyed () {
    console.log(`${this.$options.name} destroyed`)
  }
}