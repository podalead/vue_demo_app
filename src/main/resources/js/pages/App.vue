<template>
  <div id="app" class="app">
    <blog-list :blogs="this.blogs"/>
  </div>
</template>

<script>
import Axios from  'axios-observable';
import { take } from 'rxjs';
import BlogList from "../components/BlogList.vue";

export default {
  name: "App",
  components: {
    BlogList
  },
  data: function () {
    return {
      blogs: [
        {
          id: 1,
          username: "fsdfsdfsdf",
          title: "Abraham",
          message: "It was greatful",
          creation_date: new Date(),
          comments: [
            {
              id: 1,
              username: "fsdffd",
              message: "Lol=)"
            }
          ]
        }
      ]
    }
  },
  mounted: function () {
    Axios.get("/api/blog")
        .pipe(take(1))
        .subscribe((val) => {
          console.log(val.data);
          this.blogs = val.data
        });
  }
}
</script>

<style scoped>
.app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
