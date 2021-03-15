// The following example is borrowed from 
// https://vuejs.org/v2/guide/custom-directive.html

/**
 * 지시자 추가하기
 *
 * 1. Vue에 직접 directive 지시자 추가
 * 2. 파일 import 하기
 * 3. bind, inserted, update, componentUpdated, unbind 생명주기에 맞춰 작동 함수 정의하기
 *      - bind : 바인딩 될 때 한번만 호출
 *      - inserted : 바인딩 된 엘리먼트가 DOM에 삽입되었을 때
 *      - update : 포함하는 컴포넌트가 업데이트 된 후 호출됩니다. 그러나 자식이 업데이트 되기 전일 가능성이 있습니다
 *      - componentUpdated : 포함하고 있는 컴포넌트와 그 자식들 이 업데이트 된 후
 *      - unbind : 디렉티브가 엘리먼트로부터 언바인딩된 경우에만 한번 호출
 *  */
// Register a global custom directive called `v-focus`
Vue.directive('focus', {
  // When the bound element is inserted into the DOM...
  inserted: function (el) {
    // Focus the element
    el.focus()
  }
})