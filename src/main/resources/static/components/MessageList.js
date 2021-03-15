import MessageListItem from './MessageListItem.js'
/**
 * 컴포넌트화 하는 방법
 *
 * 1. message-list-item 처럼 - (대쉬) 를 이용한 파스칼표기법으로 태그를 작성
 * 2. components 프로퍼티에 MessageListItem 케밥표기법으로 컴포넌트 등록
 * 3. 하위 컴포넌트에 물려줄 값이 있거나 속성을 바인딩 하려면 v-bind 사용 :item 은 v-bind:item 의 축약 표현
 * */
export default {
  name: 'MessageList',
  template:
  `
    <div>
        <ul>
            <message-list-item v-for="item in items"
            :item="item" :key="item.id"
            @delete="deleteMessage(item)" @update="updateMessage(item)">
            </message-list-item>
        </ul>
    </div>
  `,
  props: {
    items: {
      type: Array,
      required: true
    }
  },
  components: {
    MessageListItem
  },
  methods: {
    deleteMessage (message) {
      this.$emit('delete', message)
    },
    updateMessage (message) {
      this.$emit('update', message)
    }
  }
}
