package com.jvrni.ui.home.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.pager.ExperimentalPagerApi
import com.jvrni.core.base.ViewState
import com.jvrni.core.components.*
import com.jvrni.core.navigation.AppRoutes
import com.jvrni.core.theme.Dimens
import com.jvrni.ui.home.viewmodel.HomeViewModel
import com.jvrni.core.theme.Colors
import com.jvrni.core.theme.custom.Typography
import com.jvrni.core.theme.custom.blue0094FF
import com.jvrni.core.theme.custom.gray888888
import com.jvrni.domain.posts.models.Posts
import com.jvrni.domain.stories.models.Stories
import com.jvrni.domain.users.models.User
import com.jvrni.ui.home.R
import com.jvrni.ui.home.viewmodel.HomeState
import com.jvrni.ui.profile.navigation.ProfileScreen

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onNavigate: (route: AppRoutes) -> Unit
) {
    val scrollState = rememberScrollState()
    val state by viewModel.uiState.collectAsState()

    viewModel.load()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(onNavigate)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            state?.let { state ->
                when (state) {
                    is HomeState -> {
                        Stories(state.user, state.stories)
                        Feed(state.posts)
                    }
                    is ViewState.Loading -> {
                        // TODO loading
                    }
                }
            }
        }
    }
}

@Composable
private fun TopBar(onNavigate: (route: AppRoutes) -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Dimens.smedium_padding)
    ) {
        val (textField, profile) = createRefs()

        val search = remember { mutableStateOf("") }
        TextField(
            modifier = Modifier
                .constrainAs(textField) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(profile.start)
                    bottom.linkTo(parent.bottom)
                }
                .padding(
                    start = Dimens.xxlarge_padding,
                    end = Dimens.xlarge_padding,
                    top = Dimens.medium_padding
                ),
            height = 55.dp,
            shape = RoundedCornerShape(200.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    tint = gray888888,
                    contentDescription = ""
                )
            },
            background = Colors.background,
            placeHolder = buildAnnotatedString {
                append(
                    stringResource(id = R.string.placeholder_search)
                )
                append(
                    AnnotatedString(
                        text = " ${stringResource(id = R.string.placeholder_orkut)} ",
                        spanStyle = SpanStyle(
                            color = Colors.primary,
                        )
                    )
                )
            },
            text = search
        )

        IconButton(
            modifier = Modifier
                .constrainAs(profile) {
                    top.linkTo(textField.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(textField.bottom)
                }
                .padding(
                    top = Dimens.medium_padding,
                    end = Dimens.smedium_padding
                ),
            onClick = { onNavigate.invoke(ProfileScreen) }
        ) {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = ""
            )
        }
    }
}

@Composable
private fun Stories(user: User, list: List<Stories>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Dimens.smedium_padding),
        contentPadding = PaddingValues(horizontal = Dimens.medium_padding),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        item {
            Story(StoryEntity(image = user.image, name = stringResource(id = R.string.add_story))) {}
        }

        items(list) { item ->
            Story(StoryEntity(image = item.user.image, name = item.user.name)) {}
        }
    }
}

@Composable
private fun Feed(list: List<Posts>) {
    Divider(
        modifier = Modifier.padding(top = Dimens.large_padding),
        thickness = 10.dp
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = Dimens.large_padding)
    ) {
        list.forEach { post ->
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = Dimens.xlarge_padding,
                        start = Dimens.large_padding,
                        end = Dimens.large_padding
                    )
            ) {
                val (image, column, icon, testimony, row) = createRefs()

                Image(
                    modifier = Modifier
                        .constrainAs(image) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                        .size(65.dp)
                        .border(
                            width = 0.dp,
                            color = Color.Transparent,
                            shape = CircleShape
                        ),
                    painter = painterResource(post.user.image),
                    contentDescription = ""
                )

                Column(
                    modifier = Modifier
                        .constrainAs(column) {
                            top.linkTo(image.top)
                            start.linkTo(image.end)
                        }
                        .padding(top = Dimens.small_padding),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        modifier = Modifier.padding(start = Dimens.small_padding),
                        text = post.user.name,
                        color = Colors.text,
                        style = Typography.Label.xsmall
                    )

                    Text(
                        modifier = Modifier.padding(
                            top = Dimens.xsmall_padding,
                            start = Dimens.small_padding
                        ),
                        text = "Depoimento",
                        color = Colors.unSelectText,
                        style = Typography.Label.xxsmall
                    )
                }

                IconButton(
                    modifier = Modifier.constrainAs(icon) {
                        top.linkTo(image.top)
                        bottom.linkTo(image.bottom)
                        end.linkTo(parent.end)
                    },
                    onClick = { }
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = com.jvrni.core.R.drawable.ic_dots),
                        contentDescription = ""
                    )
                }

                Testimony(
                    entity = TestimonyEntity(
                        name = post.testimony.user.name,
                        image = post.testimony.user.image,
                        description = post.testimony.description
                    ),
                    modifier = Modifier
                        .constrainAs(testimony) {
                            top.linkTo(image.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .padding(top = Dimens.medium_padding),
                    isShowingDots = false
                )

                Row(
                    modifier = Modifier
                        .constrainAs(row) {
                            top.linkTo(testimony.bottom)
                            start.linkTo(testimony.start)
                        }
                        .padding(start = Dimens.medium_padding),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { }
                    ) {
                        Icon(
                            modifier = Modifier.size(26.dp),
                            painter = painterResource(id = R.drawable.ic_heart),
                            contentDescription = ""
                        )
                    }

                    IconButton(
                        onClick = { }
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.ic_chat),
                            contentDescription = ""
                        )
                    }

                    IconButton(
                        modifier = Modifier.padding(top = 2.dp),
                        onClick = { }
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.ic_send),
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}

