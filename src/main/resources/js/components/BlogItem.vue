<template>
    <div>
        <div class="blog">
            <div class="title">
                <h2>{{ blog.title }}</h2>
                <hr />
            </div>
            <div class="message">
                {{ blog.message }}
            </div>
            <div class="info">
                <div class="info-element">blog: #{{ blog.id }}</div>
                <div class="info-element">user: {{ blog.username }}</div>
                <div class="info-element">date: {{ blog.date | dateNormalizer }}</div>
                <div class="info-element">comments: {{ blog.comments | length }}</div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "BlogItem",
        props: {
            blog: {
                id: Number,
                username: String,
                title: String,
                message: String,
                creation_date: Date,
                comments: Array
            }
        }
    }
</script>

<style scoped>
    .blog {
        padding: 0px 50px;
        margin-bottom: 10px;
        border: cadetblue solid 2px;
    }

    .title {
        padding-bottom: 20px;
    }

    .message {
        font-size: 18px;
        padding-bottom: 20px;
    }

    .info {
        font-size: 12px;
    }

    .info-element {
        display: block;
        float: left;
        padding-right: 5px;
    }
</style>