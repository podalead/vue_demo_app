<template>
    <div>
        <div class="blog">
            <div class="title">
                <h2>{{ blog.title }}</h2>
                <hr />
            </div>
            <div class="message">
                {{ $filters.cutMessageLength(blog.message) }}
            </div>
            <div class="info">
                <div class="info-element">blog: #{{ blog.id }}</div>
                <div class="info-element">user: {{ blog.username }}</div>
                <div class="info-element">date: {{ $filters.dateNormalizer(blog.date) }}</div>
                <div class="info-element">comments: {{ $filters.length(blog.comments) }}</div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "BlogItem",
        setup(props) {
        },
        props: {
            blog: {
                id: Number,
                username: String,
                title: String,
                message: String,
                createDate: Date,
                comments: Array
            }
        }
    }
</script>

<style scoped>
    .blog {
        padding: 0 50px;
        height: 175px;
        margin-bottom: 10px;
        border: cadetblue solid 2px;
    }

    .title {
        padding-bottom: 20px;
    }

    .message {
        text-align: left;
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
