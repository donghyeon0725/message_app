/**
 *** 플러그인
 *
 * 특정 프로퍼티를 모든 객체가 뷰 가질수 있도록
 * 플러그인을 확장 할 수 있다.
 * 이 때 프로퍼티를 복제하는 믹스인을 플러그인으로 사용할 수 있다.
 *
 *** 플러그인 사용하기
 *
 * 1. 기본으로 사용할 프로퍼티 모음을 만든다.
 * 2. install (Vue, options) { } 으로 Vue 객체를 받아 확장할 준비를 한다. 이 때 options은 use 할 때 넘겨준 인자 값 이다. $options 로 뷰 인스턴스에 접근이 가능하다.
 * 3. 기본으로 사용할 프로퍼티 모음에 assign 을 해서 기본으로 주는 값은 변경되지 않도록 한다. => 중요 Object.assign(switchers, options) switchers 가 options 보다 앞으로 와야 한다.
 * 4. export 으로 플러그인으로 사용할 객체를 export 한다.
 * 5. 사용하는 곳에 Vue.use(이 모듈의 이름, {기본옵션}) 를 추가한다.
 * */
const switchers = {
  created: true,
  beforeMount: true,
  mounted: true,
  destroyed: true
}

export default {
  install (Vue, options) {    
    Object.assign(switchers, options)
    
    Vue.mixin({  
      created () {
        if (switchers.created) {
          console.log(`${this.$options.name} created`)
        }        
      },
      beforeMount () {
        if (switchers.beforeMount) {
          console.log(`${this.$options.name} about to mount`)
        }        
      },
      mounted () {
        if (switchers.mounted) {
          console.log(`${this.$options.name} mounted`) 
        }        
      },  
      destroyed () {
        if (switchers.destroyed) {
          console.log(`${this.$options.name} destroyed`)
        }        
      }
    })
  }
}