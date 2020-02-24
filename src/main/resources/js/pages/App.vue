<template>
    <div id="app">
        <blog-list :blogs="this.blogs"/>
    </div>
</template>

<script>
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
        mounted: function() {
            this.$http.get("/api/blog").then(response => {
                if (response.status === 200) {
                    this.blogs = response.body;
                }
            });
        },
        methods: {

        }

    }
</script>

<style scoped>
    /*#app {*/
    /*    font-family: 'Avenir', Helvetica, Arial, sans-serif;*/
    /*    -webkit-font-smoothing: antialiased;*/
    /*    -moz-osx-font-smoothing: grayscale;*/
    /*    text-align: center;*/
    /*    color: #2c3e50;*/
    /*    margin-top: 60px;*/
    /*}*/
</style>