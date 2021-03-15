export default {
  /**
   * 모듈 생성하기
   *
   * 1. 디버깅을 사용하기 위해 name 프로퍼티 추가
   * 2. props 으로 부모 모듈의 속성 값을 주입받기
   * 3. $emit 으로 부모 모듈에 바인딩 된 이벤트 호출하기
   * 4. 상위에서 주입 받은 값인 item.text를 v-model로 양방향 바인딩 시켜두었다.
   * 5. {{ 문법 | datetime }} 이 문법은 필터를 사용한 것이다.
   * */
  name: 'MessageListItem',
  template:
  `
        <li>
            <input type="text" v-model="item.text"/> - {{ item.createdAt | datetime }} 
            <button @click="deleteClicked">X</button>
            <button @click="updateClicked">update</button>
        </li>
  `,
  props: {
    item: {
      type: Object,
      required: true
    }
  },
  methods: {
    deleteClicked () {
      this.$emit('delete');
    },
    updateClicked () {
      this.$emit('update');
    }
  }
}; 