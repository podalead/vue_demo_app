<template>
    <div>
        <blog-item v-for="blog in this.blogs" :blog="blog" :key="blog.id"/>
    </div>
</template>

<script>
    import BlogItem from "./BlogItem.vue";

    export default {
        name: "BlogList",
        props: ['blogs'],
        components: {
            BlogItem
        }
    }
</script>

<style scoped>

</style>
