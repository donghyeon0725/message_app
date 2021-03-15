/**
 ****필터 생성하기
 *
 * 1. Vue에 filter직접 추가
 *
 ****사용하기
 *
 * 1. :data-date="message.createdAt | datetime" 처럼 바인딩 할 때 | 기호화 함께 사용
 * 2. {{ message.text.toLowerCase() | addText(3) }} 처럼 보간법{{이중괄호}}에 사용 가능
 *
 ****주의하기
 *
 * 이 때 첫번 째 인자로는 message.text 나 message.createdAt 같은 값이 넘어가고 두번째 인자로는 괄호 내부의 값이 넘어감
 * function (target, ...param) {} 으로 받아서 확인 가능
 * */
const formatter = new Intl.DateTimeFormat('en-US', {
  year: 'numeric', month: 'long', week: 'long', day: 'numeric',
  hour: 'numeric', minute: 'numeric', second: 'numeric'
})
Vue.filter('datetime', function(value) {
  if (!value) return ''  
  return formatter.format(value)
})