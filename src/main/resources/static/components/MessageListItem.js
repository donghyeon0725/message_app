export default {
  name: 'MessageListItem',
  template: `<li>
            <input type="text" v-model="item.text"/> - {{ item.createdAt | datetime }} 
            <button @click="deleteClicked">X</button>
            <button @click="updateClicked">update</button>
            </li>`,
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